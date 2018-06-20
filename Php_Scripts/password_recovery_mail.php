<?php


// Code Starts :This code is to create  Connection with datatbase

$db_name =  "id2202846_pkmoney";  //"pkmoney";
$mysqlusr_name = "id2202846_root";//"root";
$mysqlusr_password = "12345";
$server_name="localhost";

$connection_string = mysqli_connect($server_name, $mysqlusr_name,$mysqlusr_password,$db_name);

// Above Code ends :This code is to create  Connection with datatbase



$user_emailid = $_POST["user_emailid"];
$user_phonenumber = $_POST["user_phonenumber"];


$msg = "Password need to be generated for emailid = ".$user_emailid." and Mobile Number = ".$user_phonenumber;


/*
$msg  = wordwrap($msg,70);
*/

$result = mail("crazybeam24@gmail.com","PkMoney - Password revcover" ,$msg);

if($result)
{
echo "1";
}
else
{
echo "0";
}
mysqli_close($connection_string);
?>