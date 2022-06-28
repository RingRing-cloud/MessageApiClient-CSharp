using System;
using System.IO;
using System.Text.RegularExpressions;
using System.Xml.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;

namespace RingRing
{
    public class Tools
    {
        /// <summary>
        /// Transform Object to XML or JSON
        /// </summary>
        /// <param name="contentType">JSON or XML, can be also application/xml or application/json</param>
        /// <param name="o">Object ot transform</param>
        /// <returns>Return a string</returns>
        public static string ReturnObjectToString(string contentType, object o)
        {
            string dataSent = "";
            if (o != null && contentType.ToLower().Contains("xml"))
            {
                //Convert to xml
                XmlAttributeOverrides overrides = new XmlAttributeOverrides();
                var stringwriter = new StringWriter();
                var serializer = new XmlSerializer(o.GetType(), overrides);
                serializer.Serialize(stringwriter, o);

                string xml = stringwriter.ToString();
                xml = Regex.Replace(xml, @">\s*<", "><");
                xml = Regex.Replace(xml, @"\r\n", "");
                xml = Regex.Replace(xml, @"\n", "");
                xml = xml.Trim();

                dataSent = xml;
            }
            else
            {
                //JSON
                var jsonSettings = new JsonSerializerSettings() { DateFormatHandling = DateFormatHandling.IsoDateFormat };
                jsonSettings.Converters.Add(new StringEnumConverter());

                dataSent = JsonConvert.SerializeObject(o, jsonSettings);
            }

            return dataSent;
        }

        public static object ConvertToObject<T>(string data)
        {
            try
            {
                //normaly the data must contains a valid Json, if not return the data string
                return JsonConvert.DeserializeObject<T>(data);
            }
            catch 
            {
                throw new Exception(data);
            }
        }
    }
}
