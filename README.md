# MessageApi
RingRing provides simple and fast API for sending and receiving text messages (SMS), calls and emails all over the world.  We take care of the telecom infrastructure and bring additional services such as Cloud Call Center solutions, Transactional emails, SIP trunking, .. 

# How to Use

- Contact us at sales@ringring.be, we will create an account for you.
- Once you have access to your account, you will be able to access to interface at https://portal.ringring.be. Here you will see all account information you need to send real messages through the API.
- Lastly, download the code source from Github, or look for the 'MessageApi' Nuget package through the NuGet Packet Manager.

# Example

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

# .Net Version

This example is in .Net Framework 4.5, but you can take this code and use it on a previous version of .Net Framework

# Installation

This SDK has a dependencie to NewtonSoft Json (last version), be sure to reference this depedencie or add this one with NuGet Packet Manager

# Documentation

http://docs.ringring.be 

