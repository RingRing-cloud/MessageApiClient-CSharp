using System;

namespace RingRing
{
    public class CancelResponse
    {
        public CancelResponse()
        {
        }

        /// <summary>
        /// Message Id
        /// </summary>
        public Guid MessageId { get; set; }

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
