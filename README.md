# MessageApi
RingRing provides simple and fast API for sending and receiving text messages (SMS), calls and emails all over the world.  We take care of the telecom infrastructure and bring additional services such as Cloud Call Center solutions, Transactional emails, SIP trunking, .. 

# How to Use

- Contact us at sales@ringring.be, we will create an account for you.
- Once you have access to your account, you will be able to access to interface at https://portal.ringring.be. Here you will see all account information you need to send real messages through the API.
- Lastly, download the code source from Github, or look for the 'MessageApi' Nuget package through the NuGet Packet Manager (.NET only).

# Example

###### CSharp (.NET)
```
class Program
{
    static void Main(string[] args)
    {
        MessageRequest r = new MessageRequest();
        r.ApiKey = "YOUR_ACCESS_KEY";
        r.To = "PHONE_NUMBER"; //Must in format E164 (32496XXYYZZ)
        r.Message = "Hello World !";

        MessageApi m = new MessageApi();
        MessageResponse resp = m.SendMessage(r);

        Console.WriteLine(resp.ResultDescription);

        Console.ReadLine();
    }
}
```
```
Example in .Net Framework 4.5, but can be used on a previous version of .NET Framework
```

###### Java ( >= 6 )
```
public class Example {

    public static void main(String[] args) {
    
        Authentication token = new Authentication("YOUR_ACCESS_KEY");
        MessageClient client = new MessageClient(token);
		
		// Example using simple parameters (usually mandatory parameters)
		try {
			MessageResponse response = client.createMessage("PHONE_NUMBER", "YOUR_MESSAGE");
		} catch (MessageException e) {
			// ...
		}
		
		// Example using request object (for detailed query) 
		try {
			MessageResponse response = client.createMessage(new MessageRequest.Builder()
				.withTo(PHONE)
				.withMessage("YOUR_MESSAGE")
				.withFrom("FROM_WHO")
				.withTimeScheduled("DD/MM/YYYY")
				//...
				.build()
			);
		} catch (MessageException e) {
			// ...
		}
		
    }
    
}
```

###### PHP ( >= 7.x )
```
<?php

	require_once("lib/autoload.php");

	$client = new Client(APIKEY);
	
	try {
		$result = $client->sendMessage(
			new MessageRequest(array(
				"to" => "PHONE_NUMBER",
				"message" => "YOUR_MESSAGE",
				"timeScheduled"=> "DD/MM/YYYY"
			))
		);
	} catch(HTTPException $e) {
		// ...
	}
	
?>
```

# Installation

This SDK has a dependencie to NewtonSoft Json (last version), be sure to reference this depedencie or add this one with NuGet Packet Manager

# Documentation

http://docs.ringring.be 

