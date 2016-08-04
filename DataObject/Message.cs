namespace RingRing
{
    public class Message
    {

        /// <summary>
        /// Unique Id returned of the SMS
        /// Can be empty
        /// </summary>
        public string MessageId { get; set; }

        /// <summary>
        /// Mobile Number
        /// </summary>
        public string To { get; set; }

        /// <summary>
        /// Status Code
        /// </summary>
        public int ResultCode { get; set; }

        /// <summary>
        /// Status Description
        /// </summary>
        public string ResultDescription { get; set; }

    }
}
