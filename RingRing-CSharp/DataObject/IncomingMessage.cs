namespace RingRing
{
    public class IncomingMessage
    {
        public IncomingMessage()
        {
            
        }
        public string MessageId { get; set; }
        public string Reference { get; set; }
        public string From { get; set; }
        public string To { get; set; }
        public string Message { get; set; }
        public string Country { get; set; }
        public string TimeReceived { get; set; }
    }
}
