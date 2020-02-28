using crudAssignemnt.Models;
using SQLite;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

using Xamarin.Forms;

namespace crudAssignemnt.Views
{
    public class GetAllCompaniesPage : ContentPage
    {

        private ListView _listview;
        string _dbPath = Path.Combine(System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal), "myDB.db3");
        public GetAllCompaniesPage()
        {
            this.Title = "Company Detail";

            var db = new SQLiteConnection(_dbPath);

            StackLayout stackLayout = new StackLayout();

            _listview= new ListView();

            _listview.ItemsSource = db.Table<Company>().OrderBy(x => x.Name).ToList();

            stackLayout.Children.Add(_listview);

            Content = stackLayout;







        }
    }
}