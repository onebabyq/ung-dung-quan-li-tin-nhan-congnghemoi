const express = require('express');
const app = express();

const router = express.Router();

const accounts = [
  {
    "id" : 1,
    "username" : "sonmabu",
    "avatar" : "None",
    "listAccountRoom" : [
        {
            "accountId": 1,
            "permission": "Admin",
            "room":{
              "id": 3,
              "lastMessageId": 1,
              "type": "Group",
              "deleted" : false,
              "adminId" : 1
            }
        },
        {
            "accountId": 1,
            "permission": "Member",
            "room":{
              "id": 4,
              "lastMessageId": 1,
              "type": "Group",
              "deleted" : false,
              "adminId" : 1
            }
        }
    ]
  },
  {
    "id" : 2,
    "username" : "toanlayloi",
    "avatar" : "None",
    "listAccountRoom" : [
        {
            "accountId": 2,
            "permission": "Member",
            "room":{
              "id": 3,
              "lastMessageId": 1,
              "type": "Group",
              "deleted" : false,
              "adminId" : 1
            }
        },
        {
            "accountId": 2,
            "permission": "Admin",
            "room":{
              "id": 4,
              "lastMessageId": 1,
              "type": "Group",
              "deleted" : false,
              "adminId" : 2
            }
        }
    ]
  }
];



router.get('/accountToRooms', (request, response) => {
	console.log(accounts);
   	response.json(accounts);
});


router.post('/accountToRooms/:accountId', (request, response) => {
    const accountId = request.params.accountId;
   const {id,lastMessageId,type,deleted,adminId} = request.body;
   for(let i = 0 ; i < accounts.length ; i++){
      if(accounts[i]['id'] == accountId){
          accounts[i]['listAccountRoom'].push({
            "accountId" : accountId,
            "permission" : "Admin",
            "room": {
              "id" : id,
              "lastMessageId": lastMessageId,
              "type": type,
              "deleted":deleted,
              "adminId":adminId
            }
          });
      }
   }

  response.json({ accounts});
   console.log(accounts);
});



module.exports = router

// app.put('/api/shopping_cart/updatewithparametersandbody',updateWithParametsAndBody);
// function updateWithParametsAndBody(req, res){
//   var body = req.body
//   var product_id = req.query.product_id
//   if(body === undefined){
//     res.statusMessage = "please send a valid body to update record";
//     res.statusCode = 400;
//     res.end();
//     return
//   }
//   //console.log(body)
//   var inventory_date = body.inventory_date
//   var system_inventory = body.system_inventory
//   var stock_sold = body.stock_sold
//   var updated_by = body.updated_by
//   // Query to update requested parameters in the System_Inventory table
//     // we are fetching exact record from the table using where clause
//   // And quering with inventory_date and product_id
//   var query = "Update System_Inventory SET inventory_date = ?, product_id=?, system_inventory=?, stock_sold=?, updated_by=? Where inventory_date=? and product_id=?"
//   // parameters array used for query function
//     var queryParams = [inventory_date,product_id,system_inventory,stock_sold,updated_by,inventory_date,product_id]
//     // query to run the sql query
//   db.query(query, queryParams, function(err,results){
//           if(err){
//         res.statusMessage = "an error has occurred";
//               res.statusCode = 400;
//             res.end();
//         throw err
//           }
//           res.statusMessage = "updated successfully";
//           res.statusCode = 200;
//           res.end();
//     })
// }