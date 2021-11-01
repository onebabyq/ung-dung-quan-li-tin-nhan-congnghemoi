const sql = require("./dbconnect.js");

// constructor
const Role = function(role) {
  this.roleId = role.roleId;
  this.name = role.name;

};

Role.create = (newRole, result) => {
  sql.query("INSERT INTO role SET ?", newRole, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created role: ", { roleId: res.insertId, ...newRole });
    result(null, { roleId: res.insertId, ...newRole });
  });
};

Role.findById = (roleId, result) => {
  sql.query(`SELECT * FROM role WHERE roleId = ${roleId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found role: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found Customer with the roleId
    result({ kind: "not_found" }, null);
  });
};

Role.findByUserId = (userId,roles, result) => {
  sql.query(`SELECT r.* FROM role r JOIN user_role ur ON r.roleId = ur.role_id WHERE ur.user_id = ${userId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found role: ", res);
      result(null, res);
      for(let i = 0 ; i < res.length;i++){
        roles.push(res[i]);
      }
      return roles;
    }

    // not found Customer with the roleId
    result({ kind: "not_found" }, null);
  });
};

Role.getAll = result => {
  sql.query("SELECT * FROM role", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log("role: ", res);
    result(null, res);
  });
};

Role.updateById = (roleId, role, result) => {
  sql.query(
    "UPDATE role SET  name = ? Where roleId = ?",
    [role.name,roleId],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found Customer with the roleId
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated role: ", { roleId: roleId, ...role });
      result(null, { roleId: roleId, ...role });
    }
  );
};

Role.remove = (roleId, result) => {
  sql.query("DELETE FROM role WHERE roleId = ?", roleId, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the roleId
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("deleted role with roleId: ", roleId);
    result(null, res);
  });
};

Role.removeAll = result => {
  sql.query("DELETE FROM role", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} role`);
    result(null, res);
  });
};

module.exports = Role;