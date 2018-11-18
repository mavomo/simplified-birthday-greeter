using System;

namespace Soat.CleanCoders.DipKata.Main
{
    public class Friend
    {
        public string FirstName { get; }
        public string LastName { get; }
        public DateTime DateOfBirth { get; }
        public string Email { get; }

        public Friend(string firstName, string lastName, DateTime dateOfBirth, string email)
        {
            FirstName   = firstName;
            LastName    = lastName;
            DateOfBirth = dateOfBirth;
            Email       = email;
        }
    }
}
