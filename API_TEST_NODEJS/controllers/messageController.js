const Message = require("../models/messageModel.js");

// Create and Save a new Message
exports.create = (req, res) => {
  // ValmessageIdate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a Message
  const message = new Message({
    messageId: req.body.messageId,
    roomId: req.body.roomId,
    fromId: req.body.fromId,
    content : req.body.content,
    contentType : req.body.contentType,
    readStatus: req.body.readStatus
  });
  // Save Message in the database
  Message.create(message, (err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Messages."
      });
    else res.send(data);
  });
};
// Retrieve all Messages from the database.
exports.findAll = (req, res) => {
  	Message.getAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving messages."
      });
    else res.send(data);
  });
};

// Find a single Message with a messageId
exports.findOne = (req, res) => {
    Message.findById(req.params.messageId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Message with messageId ${req.params.messageId}.`
        });
      } else {
        res.status(500).send({
          message: "Error retrieving Message with messageId " + req.params.messageId
        });
      }
    } else res.send(data);
  });
};

// Update a Message messageIdentified by the messageId in the request
exports.update = (req, res) => {
  // ValmessageIdate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  Message.updateById(
    req.params.messageId,
    new Message(req.body),
    (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Message with messageId ${req.params.messageId}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating Message with messageId " + req.params.messageId
          });
        }
      } else res.send(data);
    }
  );
};

// Delete a Message with the specified messageId in the request
exports.delete = (req, res) => {
  Message.remove(req.params.messageId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Message with messageId ${req.params.messageId}.`
        });
      } else {
        res.status(500).send({
          message: "Could not delete Message with messageId " + req.params.messageId
        });
      }
    } else res.send({ message: `Message was content successfully!` });
  });
};

// Delete all Messages from the database.
exports.deleteAll = (req, res) => {
  Message.removeAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all messages."
      });
    else res.send({ message: `All Messages were content successfully!` });
  });
};