# MessageApi
RingRing provides simple and fast API for sending and receiving text messages (SMS), calls and emails all over the world.  We take care of the telecom infrastructure and bring additional services such as Cloud Call Center solutions, Transactional emails, SIP trunking, .. 

# How to Use

- Contact us at coordination@ringring.be, we will create an account for you.
- Once you have access to your account, you will be able to access to interface at https://messageapi.ringring.be. Here you will see all account information you need to send real messages through the API.
- Lastly, download the code source from Github, or look for the 'MessageApi' Nuget package through the Nugget Packet Manager.

# Example

    class Program
    {
        static void Main(string[] args)
        {
            MessageRequest r = new MessageRequest();
            r.ApiKey = "3FEA3112-F610-4RBD-A2FD-B3906674B5BX";
            r.To = "32499112233";
            r.Message = "Test Message Api";

            MessageApi m = new MessageApi();
            MessageResponse resp = m.SendMessage(r);

            Console.WriteLine(resp.ResultDescription);

            Console.ReadLine();
        }
    }

# Documentation

http://docs.ringring.be 

