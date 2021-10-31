const sql = require("./dbconnect.js");

// constructor
const Message = function(message) {
  this.messageId = message.messageId;
  this.roomId = message.roomId;
  this.fromId = message.fromId;
  this.content = message.content;
  this.contentType = message.contentType;
  this.readStatus = message.readStatus;


};

Message.create = (newMessage, result) => {
  sql.query("INSERT INTO message SET ?", newMessage, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created message: ", { messageId: res.insertId, ...newMessage });
    result(null, { messageId: res.insertId, ...newMessage });
  });
};

Message.findById = (messageId, result) => {
  sql.query(`SELECT * FROM message WHERE messageId = ${messageId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found message: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found Customer with the messageId
    result({ kind: "not_found" }, null);
  });
};

Message.getAll = result => {
  sql.query("SELECT * FROM message", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log("message: ", res);
    result(null, res);
  });
};

Message.updateById = (messageId, message, result) => {
  sql.query(
    "UPDATE message SET  roomId = ?,fromId = ?,content = ?,contentType = ?,readStatus = ?  Where messageId = ?",
    [message.roomId, message.fromId, message.content, message.contentType,message.readStatus ,messageId],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found Customer with the messageId
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated message: ", { messageId: messageId, ...message });
      result(null, { messageId: messageId, ...message });
    }
  );
};

Message.remove = (messageId, result) => {
  sql.query("DELETE FROM message WHERE messageId = ?", messageId, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the messageId
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("content message with messageId: ", messageId);
    result(null, res);
  });
};

Message.removeAll = result => {
  sql.query("DELETE FROM message", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`content ${res.affectedRows} message`);
    result(null, res);
  });
};

module.exports = Message;