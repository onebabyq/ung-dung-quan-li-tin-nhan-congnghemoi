const Account = require("../models/accountModel.js");

// Create and Save a new Account
exports.create = (req, res) => {
  // ValaccountIdate request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  // Create a Account
  const account = new Account({
    accountId: req.body.accountId,
    username: req.body.username,
    avatar: req.body.avatar,
    userId: req.body.userId
  });
  // Save Account in the database
  Account.create(account, (err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while creating the Accounts."
      });
    else res.send(data);
  });
};
// Retrieve all Accounts from the database.
exports.findAll = (req, res) => {
  	Account.getAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while retrieving accounts."
      });
    else res.send(data);
  });
};

// Find a single Account with a accountId
exports.findOne = (req, res) => {
    Account.findById(req.params.accountId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Account with accountId ${req.params.accountId}.`
        });
      } else {
        res.status(500).send({
          message: "Error retrieving Account with accountId " + req.params.accountId
        });
      }
    } else res.send(data);
  });
};

// Update a Account accountIdentified by the accountId in the request
exports.update = (req, res) => {
  // ValaccountIdate Request
  if (!req.body) {
    res.status(400).send({
      message: "Content can not be empty!"
    });
  }

  Account.updateById(
    req.params.accountId,
    new Account(req.body),
    (err, data) => {
      if (err) {
        if (err.kind === "not_found") {
          res.status(404).send({
            message: `Not found Account with accountId ${req.params.accountId}.`
          });
        } else {
          res.status(500).send({
            message: "Error updating Account with accountId " + req.params.accountId
          });
        }
      } else res.send(data);
    }
  );
};

// Delete a Account with the specified accountId in the request
exports.delete = (req, res) => {
  Account.remove(req.params.accountId, (err, data) => {
    if (err) {
      if (err.kind === "not_found") {
        res.status(404).send({
          message: `Not found Account with accountId ${req.params.accountId}.`
        });
      } else {
        res.status(500).send({
          message: "Could not delete Account with accountId " + req.params.accountId
        });
      }
    } else res.send({ message: `Account was deleted successfully!` });
  });
};

// Delete all Accounts from the database.
exports.deleteAll = (req, res) => {
  Account.removeAll((err, data) => {
    if (err)
      res.status(500).send({
        message:
          err.message || "Some error occurred while removing all accounts."
      });
    else res.send({ message: `All Accounts were deleted successfully!` });
  });
};