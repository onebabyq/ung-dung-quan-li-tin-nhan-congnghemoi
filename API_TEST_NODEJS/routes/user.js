const express = require('express');
const app = express();

const router = express.Router();
const users = [
		{
			"id": 3,
			"soDienThoai": "0123456789",
			"password": "123456789",
			"enable": true
		},
		{
			"id": 4,
			"soDienThoai": "0123456788",
			"password": "123456789",
			"enable": true
		},
		{
			"id": 5,
			"soDienThoai": "0123456787",
			"password": "123456789",
			"enable": true
		}
	];



router.get('/users', (request, response) => {
	console.log(users);
   	response.json(users);
});


router.post('/users', (request, response) => {
   const {id,soDienThoai,password,enable} = request.body;
   if (id) {
      	users.push({id,soDienThoai,password,enable});
     	// response.json({ok: true, users});
      	response.json({ users});
   }
   console.log(users);
});

router.put('/users/:id', (request, response) => {
	let id = request.params.id;
   const {soDienThoai,password,enable} = request.body;
   for(let i = 0 ; i < users.length ; i++){
   		if(users[i]['id']==id){
   			users[i]['soDienThoai'] = soDienThoai;
   			users[i]['password'] = password;
   			users[i]['enable'] = enable;
   		}
   }

    response.json({ users});
   
  	console.log(users);
});
router.delete('/users/:id', (request, response) => {
	let id = request.params.id;
   const {soDienThoai,password,enable} = request.body;
   for(let i = 0 ; i < users.length ; i++){
   		if(users[i]['id']==id){
   			users.splice(i,1);
   		}
   }

    response.json({ users});
   
  	console.log(users);
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