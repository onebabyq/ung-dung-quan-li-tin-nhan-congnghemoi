const sql = require("./dbconnect.js");

// constructor
const Account = function(account) {
  this.accountId = account.accountId;
  this.username = account.username;
  this.avatar = account.avatar;
  this.userId = account.userId;
};

Account.create = (newAccount, result) => {
  sql.query("INSERT INTO account SET ?", newAccount, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created account: ", { accountId: res.insertId, ...newAccount });
    result(null, { accountId: res.insertId, ...newAccount });
  });
};

Account.findById = (accountId, result) => {
  sql.query(`SELECT * FROM account WHERE accountId = ${accountId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found account: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found Customer with the accountId
    result({ kind: "not_found" }, null);
  });
};

Account.getAll = result => {
  sql.query("SELECT * FROM account", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log("account: ", res);
    result(null, res);
  });
};

Account.updateById = (accountId, account, result) => {
  sql.query(
    "UPDATE account SET  username = ?, avatar = ?, userId = ? WHERE accountId = ?",
    [account.username, account.avatar, account.userId, accountId],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found Customer with the accountId
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated account: ", { accountId: accountId, ...account });
      result(null, { accountId: accountId, ...account });
    }
  );
};

Account.remove = (accountId, result) => {
  sql.query("DELETE FROM account WHERE accountId = ?", accountId, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the accountId
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("deleted account with accountId: ", accountId);
    result(null, res);
  });
};

Account.removeAll = result => {
  sql.query("DELETE FROM account", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} account`);
    result(null, res);
  });
};

module.exports = Account;