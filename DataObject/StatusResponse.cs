using System.Collections.Generic;

namespace RingRing
{
    public class StatusResponse
    {
        public StatusResponse()
        {

        }

        public int NumberOfRecords { get; set; }
        public int RemainingRecords { get; set; }
        public int ResultCode { get; set; }
        public string ResultDescription { get; set; }

        public List<StatusMessage> StatusMessages { get; set; }

    }
}
