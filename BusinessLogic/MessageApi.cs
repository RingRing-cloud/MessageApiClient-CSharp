using System;
using System.IO;
using System.Net;
using System.Text;

namespace RingRing
{
    public class MessageApi
    {
        
        /// <summary>
        /// Send SMS Message 
        /// </summary>
        /// <param name="request">MessageRequest object</param>
        /// <param name="sandbox">If you use SandBox, your message is a test message and it will not delivered</param>
        /// <returns>MessageResponse object</returns>
        public MessageResponse SendMessage(MessageRequest request, bool sandbox = false)
        {
            string url = "https://api.ringring.be/sms/" + ((sandbox) ? "sandbox" : "v1") + "/Message";

            string data = Tools.ReturnObjectToString("json", request);
            string result = Post(url, data);

            return (MessageResponse)Tools.ConvertToObject<MessageResponse>(result);
        }

        /// <summary>
        /// Cancel a message if this one is still to send
        /// </summary>
        /// <param name="request">CancelRequest object</param>
        /// <param name="sandbox">If you use SandBox, your message will be cancelled only if this one has been inserted in the SandBox</param>
        /// <returns>CancelResponse response</returns>
        public CancelResponse CancelMessage(CancelRequest request, bool sandbox = false)
        {
            string url = string.Format("https://api.ringring.be/sms/{0}/Cancel", ((sandbox) ? "sandbox" : "v1"));
            string data = Tools.ReturnObjectToString("json", request);
            string result = Post(url, data);

            return (CancelResponse)Tools.ConvertToObject<CancelResponse>(result);
        }

        /// <summary>
        /// Status of your messages, you can pass a MaxRecords parameters (default = 100)
        /// </summary>
        /// <param name="request">StatusMessageRequest object</param>
        /// <param name="sandbox">If you use SandBox, you see only messages sent through SandBox</param>
        /// <returns>StatusMessageResponse object</returns>
        public StatusMessageResponse GetStatusMessage(StatusMessageRequest request, bool sandbox = false)
        {
            string url = string.Format("https://api.ringring.be/sms/{0}/StatusMessage", ((sandbox) ? "sandbox" : "v1"));
            string data = Tools.ReturnObjectToString("json", request);
            string result = Post(url, data);

            return (StatusMessageResponse)Tools.ConvertToObject<StatusMessageResponse>(result);
        }

        /// <summary>
        /// Status of one message
        /// </summary>
        /// <param name="request">StatusRequest object</param>
        /// <param name="sandbox">If you use SandBox, you see only message sent through SandBox</param>
        /// <returns>StatusResponse object</returns>
        public StatusResponse GetStatus(StatusRequest request, bool sandbox = false)
        {
            string url = string.Format("https://api.ringring.be/sms/{0}/Status", ((sandbox) ? "sandbox" : "v1"));
            string data = Tools.ReturnObjectToString("json", request);
            string result = Post(url, data);

            return (StatusResponse)Tools.ConvertToObject<StatusResponse>(result);
        }

        /// <summary>
        /// List of Incoming SMS messages
        /// </summary>
        /// <param name="request">IncomingRequest object</param>
        /// <returns>IncomingResponse object</returns>
        public IncomingResponse GetIncoming(IncomingRequest request)
        {
            string url = "https://api.ringring.be/sms/v1/Incoming";
            string data = Tools.ReturnObjectToString("json", request);
            string result = Post(url, data);

            return (IncomingResponse)Tools.ConvertToObject<IncomingResponse>(result);
        }

        /// <summary>
        /// POST data on url
        /// </summary>
        /// <param name="url">url from RingRing Company</param>
        /// <param name="data">data JSON to post</param>
        /// <returns>return result string</returns>
        private string Post(string url, string data)
        {
            string result = "";
            try
            {
                using (WebClient wc = new WebClient())
                {
                    wc.Encoding = Encoding.UTF8; //important !
                    wc.Headers[HttpRequestHeader.ContentType] = "application/json; charset=UTF-8";
                    wc.Headers[HttpRequestHeader.UserAgent] = "Ring Ring MessageApi NuGet";

                    result = wc.UploadString(url, data);
                }
            }
            catch (WebException ex)
            {
                //if some value of properties are wrong, an error occurs
                //get the result and transform to the current object T
                HttpWebResponse webResponse = ex.Response as HttpWebResponse;
                if (webResponse != null)
                {
                    try
                    {
                        using (StreamReader stIn = new StreamReader(webResponse.GetResponseStream()))
                        {
                            //Get the response, normaly in Json, if not it's a crash
                            result = stIn.ReadToEnd();
                        }
                    }
                    catch
                    {
                    }

                    webResponse.Close();
                }
            }

            return result;
        }
    }

    public enum RequestFormat
    {
        JSON,
        XML
    }
}
