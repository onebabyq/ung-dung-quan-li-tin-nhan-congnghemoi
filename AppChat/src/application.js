//=============== LIB ================
// Express
const express = require('express');
// nodemon
const nodemon = require('nodemon');
// multer
const multer = require('multer');
const convertToJson = multer();
// ejs
const ejs = require('ejs');
// path
const path = require('path');

const app = express();

// Xử lý static file
app.use(express.static(path.join(__dirname,'public')));

// Set view Template Engine laf ejs
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'resources/views/'));

const route = require('./routes');
// init route
route(app);

app.get('/', (req,res) => {
    res.send('Hello');
})

app.listen(8888, console.log('Server is listening in port 8888!'));