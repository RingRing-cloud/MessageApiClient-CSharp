namespace RingRing
{
    public class StatusMessageResponse
    {
        public string MessageId { get; set; }
        public string Reference { get; set; }
        public string StatusCode { get; set; }
        public string StatusDescription { get; set; }
        public string TimeSubmitted { get; set; }
        public string DeliveryTime { get; set; }
        public string Country { get; set; }
        public string To { get; set; }
        public string Message { get; set; }

        public int ResultCode { get; set; }

        public string ResultDescription { get; set; }

        public string TimeScheduled { get; set; }
        public string From { get; set; }
        public string MessageEncoding { get; set; }
        public int NumberOfParts { get; set; }
        public int NumberOfChars { get; set; }
    }
}
