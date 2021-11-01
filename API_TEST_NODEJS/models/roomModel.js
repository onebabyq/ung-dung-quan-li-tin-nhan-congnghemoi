const sql = require("./dbconnect.js");

// constructor
const Room = function(room) {
  this.roomId = room.roomId;
  this.lastMessageId = room.lastMessageId;
  this.type = room.type;
  this.deleted = room.deleted;
  this.adminId = room.adminId;

};

Room.create = (newRoom, result) => {
  sql.query("INSERT INTO room SET ?", newRoom, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    console.log("created room: ", { roomId: res.insertId, ...newRoom });
    result(null, { roomId: res.insertId, ...newRoom });
  });
};

Room.findById = (roomId, result) => {
  sql.query(`SELECT * FROM room WHERE roomId = ${roomId}`, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(err, null);
      return;
    }

    if (res.length) {
      console.log("found room: ", res[0]);
      result(null, res[0]);
      return;
    }

    // not found Customer with the roomId
    result({ kind: "not_found" }, null);
  });
};

Room.getAll = result => {
  sql.query("SELECT * FROM room", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log("room: ", res);
    result(null, res);
  });
};

Room.updateById = (roomId, room, result) => {
  sql.query(
    "UPDATE room SET  lastMessageId = ?,type = ?,deleted = ?,adminId = ?  Where roomId = ?",
    [room.lastMessageId, room.type, room.deleted, room.adminId ,roomId],
    (err, res) => {
      if (err) {
        console.log("error: ", err);
        result(null, err);
        return;
      }

      if (res.affectedRows == 0) {
        // not found Customer with the roomId
        result({ kind: "not_found" }, null);
        return;
      }

      console.log("updated room: ", { roomId: roomId, ...room });
      result(null, { roomId: roomId, ...room });
    }
  );
};

Room.remove = (roomId, result) => {
  sql.query("DELETE FROM room WHERE roomId = ?", roomId, (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    if (res.affectedRows == 0) {
      // not found Customer with the roomId
      result({ kind: "not_found" }, null);
      return;
    }

    console.log("deleted room with roomId: ", roomId);
    result(null, res);
  });
};

Room.removeAll = result => {
  sql.query("DELETE FROM room", (err, res) => {
    if (err) {
      console.log("error: ", err);
      result(null, err);
      return;
    }

    console.log(`deleted ${res.affectedRows} room`);
    result(null, res);
  });
};

module.exports = Room;