<?php

// Code Starts :This code is to create  Connection with datatbase

$db_name =  "id2202846_pkmoney";  //"pkmoney";
$mysqlusr_name = "id2202846_root";//"root";
$mysqlusr_password = "12345";
$server_name="localhost";

$connection_string = mysqli_connect($server_name, $mysqlusr_name,$mysqlusr_password,$db_name);

// Above Code ends :This code is to create  Connection with datatbase

 // for testing only :

$message = $_POST['message'];

$title = "Push Notification";

//$_POST['title'];
$email_id=$_POST['user_emailid'];

$path_to_fcm = 'https://fcm.googleapis.com/fcm/send';

$server_key = "AIzaSyCYWj3KiFbd1fACoraDDBXWZzNxbDhDNB8";

$get_fcm_token = "select  fcm_server_token from user_registration where User_EmailId = '$email_id' ";

$result = mysqli_query($connection_string, $get_fcm_token);

$row = mysqli_fetch_row($result);


$key = $row[0]; // by this way you can also access multiple row if there. In our case we have only one row.


$headers = array(
                              'Authorization:key='  .$server_key,
							  'Content-Type:application/json'
							  );

							  
$fields = array('to'=>$key, 'notification'=>array('title'=>$title, 'body'=>$message));

$payload =json_encode($fields);

$curl_session = curl_init();

curl_setopt($curl_session,CURLOPT_URL, $path_to_fcm);
curl_setopt($curl_session,CURLOPT_POST, true);
curl_setopt($curl_session,CURLOPT_HTTPHEADER, $headers);
curl_setopt($curl_session,CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl_session,CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($curl_session,CURLOPT_IPRESOLVE, CURL_IPRESOLVE_V4);
curl_setopt($curl_session,CURLOPT_POSTFIELDS, $payload);

$result = curl_exec($curl_session);

curl_close($curl_session);

mysqli_close($connection_string);

?>