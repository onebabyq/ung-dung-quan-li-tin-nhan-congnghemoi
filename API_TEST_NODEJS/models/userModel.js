const sql = require("./dbconnect.js");
const Role = require("../models/roleModel.js");
// constructor
const User = function(user) {
  this.id = user.id;
  this.soDienThoai = user.soDienThoai;
  this.password = user.password;
  this.enable = user.enable;
  this.roles = user.roles;
};



User.create = (newUser, result) => {
  sql.query("INSERT INTO users SET ?", newUser, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created user: ", { id: res.insertId, ...newUser });
    result(null, { id: res.insertId, ...newUser });
  });
};

User.findById = (userId, result) => {
  sql.query(`SELECT * FROM users WHERE id = ${userId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found user: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found Customer with the id
    result({ kind: "not_found" }, null);
  });
};

User.getAll = result => {
  sql.query("SELECT * FROM users", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }
    const users = [];
    
    for(let k = 0 ; k < res.length ; k++){
      
      let roless = [] ;
      
      
      //temp = getRole(res[k].id,roless);
      console.log("temp : "+getRole(res[k].id,roless));
      // if(temp!=null){
      //   for(let i = 0 ; i < temp.length;i++){
      //     roless.push(temp[i]);
      //   }
      // }
      
      const user = new User({
        id: res[k].id,
        soDienThoai: res[k].soDienThoai,
        password: res[k].password,
        enable: res[k].enable,
        roles: roless
      });
             
     // console.log("user test: "+user.roles);
      users.push(user);
    }
    
      

    console.log("users: ", users);
    result(null, users);
  });
};


function getRole(userId,roles){
  let roless=[];
  return Role.findByUserId(userId,roles,(err, data)=>{
     //  console.log("length: "+data.length);
        if(data){
          for(let i = 0 ; i<data.length;i++){
            roless.push(new Role({
              roleId: data[i].roleId,
              name: data[i].name
            }));
            console.log(roless[i]);
          }
          console.log('length love: '+roless.length);
        }
      }); 
   return null;
}


User.updateById = (id, user, result) => {
  sql.query(
    "UPDATE users SET  soDienThoai = ?, password = ?, enable = ? WHERE id = ?",
    [user.soDienThoai, user.password, user.enable, id],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found Customer with the id
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated user: ", { id: id, ...user });
      result(null, { id: id, ...user });
    }
  );
};

User.remove = (id, result) => {
  sql.query("DELETE FROM users WHERE id = ?", id, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the id
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("deleted user with id: ", id);
    result(null, res);
  });
};

User.removeAll = result => {
  sql.query("DELETE FROM users", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} users`);
    result(null, res);
  });
};

module.exports = User;