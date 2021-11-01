const Room = require("../models/roomModel.js");

// Create and Save a new Room
exports.create = (req, res) => {
  // ValroomIdate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a Room
  const room = new Room({
    roomId: req.body.roomId,
    lastMessageId: req.body.lastMessageId,
    type: req.body.type,
    deleted : req.body.deleted,
    adminId : req.body.adminId
  });
  // Save Room in the database
  Room.create(room, (err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Rooms."
      });
    else res.send(data);
  });
};
// Retrieve all Rooms from the database.
exports.findAll = (req, res) => {
  	Room.getAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving rooms."
      });
    else res.send(data);
  });
};

// Find a single Room with a roomId
exports.findOne = (req, res) => {
    Room.findById(req.params.roomId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Room with roomId ${req.params.roomId}.`
        });
      } else {
        res.status(500).send({
          message: "Error retrieving Room with roomId " + req.params.roomId
        });
      }
    } else res.send(data);
  });
};

// Update a Room roomIdentified by the roomId in the request
exports.update = (req, res) => {
  // ValroomIdate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  Room.updateById(
    req.params.roomId,
    new Room(req.body),
    (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Room with roomId ${req.params.roomId}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating Room with roomId " + req.params.roomId
          });
        }
      } else res.send(data);
    }
  );
};

// Delete a Room with the specified roomId in the request
exports.delete = (req, res) => {
  Room.remove(req.params.roomId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Room with roomId ${req.params.roomId}.`
        });
      } else {
        res.status(500).send({
          message: "Could not delete Room with roomId " + req.params.roomId
        });
      }
    } else res.send({ message: `Room was deleted successfully!` });
  });
};

// Delete all Rooms from the database.
exports.deleteAll = (req, res) => {
  Room.removeAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all rooms."
      });
    else res.send({ message: `All Rooms were deleted successfully!` });
  });
};