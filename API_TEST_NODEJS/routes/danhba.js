const express = require('express');
const app = express();

const router = express.Router();
//Du lieu demo
const accounts = [
		{
			"id": 1,
      "username" : "sonmabu",
      "avatar" : "None",
			"listFriend": [
          {
            "id": 1,
            "friendId": 2,
            "username": "toanlayloi",
            "avatar" : "None"
          },
          {
            "id": 1,
            "friendId": 3,
            "username": "lylulu",
            "avatar" : "None"
          }
      ]
		},
		{
      "id": 2,
      "username" : "toanlayloi",
      "avatar" : "None",
      "listFriend": [
          {
            "id": 2,
            "friendId": 1,
            "username": "sonmabu",
            "avatar" : "None"
          },
          {
            "id": 2,
            "friendId": 3,
            "username": "lylulu",
            "avatar" : "None"
          },
          {
            "id": 2,
            "friendId": 4,
            "username": "thythy",
            "avatar" : "None"
          }
      ]
    },
    {
      "id": 3,
      "username" : "lylulu",
      "avatar" : "None",
      "listFriend": [
          {
            "id": 3,
            "friendId": 2,
            "username": "toanlayloi",
            "avatar" : "None"
          },
          {
            "id": 3,
            "friendId": 1,
            "username": "sonmabu",
            "avatar" : "None"
          },
          {
            "id": 3,
            "friendId": 4,
            "username": "thythy",
            "avatar" : "None"
          }
      ]
    },
    {
      "id": 4,
      "username" : "thythy",
      "avatar" : "None",
      "listFriend": [
          {
            "id": 4,
            "friendId": 2,
            "username": "toanlayloi",
            "avatar" : "None"
          } ,
          {
            "id": 4,
            "friendId": 3,
            "username": "lylulu",
            "avatar" : "None"
          }
      ]
    }
	];


//Lay danh sach ban be tu id
router.get('/danhba/:id', (request, response) => {
    const id = request.params.id;

      for(let k = 0 ; k < accounts.length ; k++){
          console.log(accounts[k]);
            response.json(accounts[k]);
      }
           
       
	   

   
});

//THem ban be 
router.post('/danhba/:id/:friendId', (request, response) => {
  //Get parametter tu URL
  const id = request.params.id;
  const friendId = request.params.friendId;

  //Khai bao username va avatar cua friend
  var username_ac,username_fr;
  var avatar_ac, avatar_fr;
  //Tim kiem username va avatar cua friend
  for(let j = 0 ; j < accounts.length; j++){
    if(accounts[j]['id'] == friendId){
        username_fr = accounts[j]['username'];
        avatar_fr = accounts[j]['avatar'];
    }
  }
  //Tim kiem username va avatar cua account
  for(let j = 0 ; j < accounts.length; j++){
    if(accounts[j]['id'] == id){
        username_ac = accounts[j]['username'];
        avatar_ac = accounts[j]['avatar'];
    }
  }
  //Them account cua ban be vao listFriend cua minh
  for(let i = 0 ; i < accounts.length; i++){
    if(accounts[i]['id'] == id){
        accounts[i]['listFriend'].push({
          "id": id,
           "friendId": friendId,
           "username": username_fr,
           "avatar": avatar_fr
         });
    }
  }
  //Them account cua ban be vao listFriend cua friend
  for(let i = 0 ; i < accounts.length; i++){
    if(accounts[i]['id'] == friendId){
        accounts[i]['listFriend'].push({
          "id": id,
           "friendId": friendId,
           "username": username,
           "avatar": avatar
         });
    }
  }

    for(let k = 0 ; k < accounts.length ; k++){
          console.log(accounts[k]);
            response.json(accounts[k]);
      }
           
});


router.delete('/danhba/:id/:friendId', (request, response) => {
	 //Get parametter tu URL
  const id = request.params.id-1;
  const friendId = request.params.friendId-1;




  

  response.send("Them ban thanh cong");
   //Xuat ra man hinh console
   console.log("Them ban thanh cong");
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