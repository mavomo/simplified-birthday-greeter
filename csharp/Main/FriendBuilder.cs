using System;

namespace Soat.CleanCoders.DipKata.Main
{
    public class FriendBuilder
    {
        private string   _firstName   = "John";
        private string   _lastName    = "Doe";
        private DateTime _dateOfBirth = new DateTime(1980, 9, 10);
        private string   _email       = "john.doe@foobar.com";

        public static FriendBuilder AFriend()
        {
            return new FriendBuilder();
        }

        public FriendBuilder WithEmail(string email)
        {
            _email = email;
            return this;
        }

        public FriendBuilder WithFirstName(string firstName)
        {
            _firstName = firstName;
            return this;
        }

        public FriendBuilder WithLastName(string lastName)
        {
            _lastName = lastName;
            return this;
        }

        public FriendBuilder WithDateOfBirth(DateTime dateOfBirth)
        {
            _dateOfBirth = dateOfBirth;
            return this;
        }

        public Friend Build()
        {
            return new Friend(_firstName, _lastName, _dateOfBirth, _email);
        }
    }
}
