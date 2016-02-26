using System.Collections.Generic;

namespace RingRing
{
    public class IncomingResponse
    {
        public IncomingResponse()
        {
            
        }
        /// <summary>
        /// Number of records
        /// </summary>
        public int NumberOfRecords { get; set; }

        /// <summary>
        /// Remaining records
        /// </summary>
        public int RemainingRecords { get; set; }

        /// <summary>
        /// Incoming messages
        /// </summary>
        public List<IncomingMessage> IncomingMessages { get; set; }

        /// <summary>
        /// Error Status Code
        /// </summary>
        public int ResultCode { get; set; }

        /// <summary>
        /// Error Status Description
        /// </summary>
        public string ResultDescription { get; set; }
    }
}
