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
    public class DeletecompanyPage : ContentPage
    {
        private ListView _listview;
        private Button _button;

        Company _company = new Company();

        string _dbPath = Path.Combine(System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal), "myDB.db3");
        public DeletecompanyPage()
        {
            this.Title = "Delete Company";

            var db = new SQLiteConnection(_dbPath);

            StackLayout stackLayout = new StackLayout();

            _listview = new ListView();
            _listview.ItemsSource = db.Table<Company>().OrderBy(x => x.Name).ToList();
            _listview.ItemSelected += _listview_ItemSelected;
            stackLayout.Children.Add(_listview);

            _button = new Button();
            _button.Text = "Delete";
            _button.Clicked += _button_Clicked;
            stackLayout.Children.Add(_button);

            Content = stackLayout;
        }

        private void _listview_ItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            _company = (Company)e.SelectedItem;
        }
        private async void _button_Clicked(object sender, EventArgs e)
        {

            var db = new SQLiteConnection(_dbPath);
            db.Table<Company>().Delete(x=>x.Id == _company.Id);
            await Navigation.PopAsync();
        }
    }
}