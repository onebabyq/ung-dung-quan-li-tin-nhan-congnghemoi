
const express = require("express");
const multer = require("multer");





//middleware
const convertformToJson = multer();
const app = express();

const cors = require('cors');
app.use(express.json());
app.use(cors());

//app.use(express.json({extended : false}));
app.use(express.static('./views'));
app.set('view engine', 'ejs');
app.set('views', './views');




//app.use('/', require('./routes/userRotes'));
app.use('/', require('./routes/room'));
app.use('/', require('./routes/danhba'));


require("./routes/userRoutes.js")(app);
require("./routes/accountRoutes.js")(app);
require("./routes/roleRoutes.js")(app);
app.listen(3000,()=>{
	console.log('Server is running on port 3000!');
});
