<?php

// Code Starts :This code is to create  Connection with datatbase

$db_name =  "id2202846_pkmoney";  //"pkmoney";
$mysqlusr_name = "id2202846_root";//"root";
$mysqlusr_password = "12345";
$server_name="localhost";

$connection_string = mysqli_connect($server_name, $mysqlusr_name,$mysqlusr_password,$db_name);

// Above Code ends :This code is to create  Connection with datatbase

 // for testing only :

/* 

$user_emailid = "crazy@gmail.com";

$user_password1 = "123456789";

*/

$subject_name = $_POST["subject_name"];

 // contain list of emailids as String in the form of - [aa@gmail.com, abc@gmail.com, ar@gmail.com]
$email_id = $_POST["user_emailid"];

/*******************************************************************************************/

$email_id = str_replace("[","",$email_id);

$email_id = str_replace("]","",$email_id);

//Break a string into an array:

$list_of_emailids = explode(",",$email_id);

for($i=0;$i<count($list_of_emailids);$i++)
{
  $list_of_emailids[$i] = trim($list_of_emailids[$i]); // to remove whitespace from end and last of words.
	
	
// if you want to pass array to our java class use json_encode.

//echo   json_encode($list_of_emailids);

/***************************************************************************************/

$get_users_query = "select  $subject_name  from available_time_24f  where  email_id = '$list_of_emailids[$i]'";

$get_dataset =  mysqli_query($connection_string,$get_users_query);	

	/*
In above example the constant MYSQL_ASSOC is used as the second argument to mysql_fetch_array(), so that it returns the row as an associative array. With an associative array you can access the field by using their name instead of using the index.
*/

/*
if we want to check whether query returns any row or not, best way to check it by using "mysqli_num_rows".
*/

if(mysqli_num_rows($get_dataset)!=0 )
{

while ($column = mysqli_fetch_array($get_dataset,MYSQLI_ASSOC) )
{
$free_time[$i]= $column[$subject_name];
}

/*
below code is to check the condition when query returns row but values are blank/empty.
*/
if($free_time[$i]!="") 
{

$get_user_free_time[$i]= $free_time[$i];
}
else
{
//echo  "1700";  // by default we will return 5:00 pm
$get_user_free_time[$i]= "1700";
}

}
else
{
//echo  "1700";  // by default we will returns 5:00 pm
$get_user_free_time[$i]= "1700";
}
	
} // for loop ends.

// if you want to pass array to our java class use json_encode.

echo json_encode($get_user_free_time); // this will get the list of user free time.

mysqli_close($connection_string);

?>