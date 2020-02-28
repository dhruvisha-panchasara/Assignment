using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace crudAssignemnt.Models
{
    public class Company
    {
        [PrimaryKey]
        public int Id { get; set; }

        public String Name { get; set; }

        public String Address { get; set; }

       
        public override string ToString()
        {
            return this.Name + "(" + this.Address + ")";
        }
    }
}
