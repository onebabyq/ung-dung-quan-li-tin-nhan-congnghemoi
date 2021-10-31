module.exports = app => {
  const room = require("../controllers/roomController.js");

  // Create a new Customer
  app.post("/room", room.create);

  // Retrieve all room
  app.get("/room", room.findAll);

  // Retrieve a single Customer with roomId
  app.get("/room/:roomId", room.findOne);

  // Update a Customer with roomId
  app.put("/room/:roomId", room.update);

  // Delete a Customer with roomId
  app.delete("/room/:roomId", room.delete);

  // Create a new Customer
  app.delete("/room", room.deleteAll);
};