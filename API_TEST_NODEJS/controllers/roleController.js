const Role = require("../models/roleModel.js");

// Create and Save a new Role
exports.create = (req, res) => {
  // Validate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a Role
  const role = new Role({
    id: req.body.roleId,
    name: req.body.name
  });
  // Save Role in the database
  Role.create(role, (err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Roles."
      });
    else res.send(data);
  });
};
// Retrieve all Roles from the database.
exports.findAll = (req, res) => {
  	Role.getAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving roles."
      });
    else res.send(data);
  });
};

// Find a single Role with a id
exports.findOne = (req, res) => {
    Role.findById(req.params.id, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Role with id ${req.params.id}.`
        });
      } else {
        res.status(500).send({
          message: "Error retrieving Role with id " + req.params.id
        });
      }
    } else res.send(data);
  });
};

// Update a Role identified by the id in the request
exports.update = (req, res) => {
  // Validate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  Role.updateById(
    req.params.roleId,
    new Role(req.body),
    (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Role with roleId ${req.params.roleId}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating Role with roleId " + req.params.roleId
          });
        }
      } else res.send(data);
    }
  );
};

// Delete a Role with the specified id in the request
exports.delete = (req, res) => {
  Role.remove(req.params.roleId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Role with roleId ${req.params.roleId}.`
        });
      } else {
        res.status(500).send({
          message: "Could not delete Role with roleId " + req.params.roleId
        });
      }
    } else res.send({ message: `Role was deleted successfully!` });
  });
};

// Delete all Roles from the database.
exports.deleteAll = (req, res) => {
  Role.removeAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all roles."
      });
    else res.send({ message: `All Roles were deleted successfully!` });
  });
};