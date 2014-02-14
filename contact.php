<?php
	/* Sample dummy php script
	$people = array("Chris", "John", "Thomas");
	foreach($people as $person) {
		echo "<p>" . $person . "</p>";
	}
	$name = $_POST["name"];
	echo "Hello, " . $name . "!";*/
	if(isset($_POST['submit'])) {
		$to = "webmaster102@gmail.com";
		$subject = "Contact Information";
		$name = $_POST['name'];
		$company = $_POST['company'];
		$email = $_POST['email'];
		$phone = $_POST['phone'];
		$message = $_POST['message'];
		$body = "Name: $name \n\n Company Name: $company \n\n E-Mail Address: $email \n\n Phone Number: $phone \n\n Message: $message";
		//echo "Thank you for your response!";
		header("Location: /index.html");
		mail($to, $subject, $body);
	} else {
		//echo "Error: Please try sending your message again!";
		header("Location: /index.html");
	}
?>
