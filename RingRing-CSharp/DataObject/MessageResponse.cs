using System.Collections.Generic;

namespace RingRing
{
    /// <summary>
    /// Response object
    /// </summary>
    
    public class MessageResponse
    {
        public MessageResponse()
        {
        }

        /// <summary>
        /// Count of message
        /// </summary>
        public int MessageCount { get; set; }

        /// <summary>
        /// Your Reference
        /// </summary>
        public string Reference { get; set; }

        public List<Message> Messages { get; set; }

        public int ResultCode { get; set; }

        public string ResultDescription { get; set; }
    }

   

    public class Messages : List<Message>
    {
            
    }
}