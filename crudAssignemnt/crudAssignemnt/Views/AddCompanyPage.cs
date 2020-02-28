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
    public class AddCompanyPage : ContentPage
    {
        private Entry _nameEntry;
        private Entry _adressEntry;
        private Button _saveButton;


        string _dbPath = Path.Combine(System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal), "myDB.db3");
        public AddCompanyPage()
        {
            this.Title = "Add Company";

            StackLayout stackLayout = new StackLayout();

            _nameEntry = new Entry();
            _nameEntry.Keyboard = Keyboard.Text;
            _nameEntry.Placeholder = "Company Name";
            stackLayout.Children.Add(_nameEntry);


            _adressEntry = new Entry();
            _adressEntry.Keyboard = Keyboard.Text;
            _adressEntry.Placeholder = "Company Adress";
            stackLayout.Children.Add(_adressEntry);

            _saveButton = new Button();
            _saveButton.Text = "Add";
            _saveButton.Clicked += _saveButton_Clicked;
            stackLayout.Children.Add(_saveButton);

            Content = stackLayout;
        }

        private async void _saveButton_Clicked(object sender, EventArgs e)
        {
            var db = new SQLiteConnection(_dbPath);
            db.CreateTable<Company>();

            var maxPK = db.Table<Company>().OrderByDescending(c => c.Id).FirstOrDefault();

            Company company = new Company()
            {
                Id = (maxPK == null ? 1 : maxPK.Id + 1),
                Name = _nameEntry.Text,
                Address = _adressEntry.Text,

            };

            db.Insert(company);
            await DisplayAlert(null, company.Name + " " + company.Address + "Saved", "OK");
            await Navigation.PopAsync();

        }
    }
}