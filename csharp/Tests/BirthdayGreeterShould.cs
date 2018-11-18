using System;
using System.IO;
using System.Linq;
using FluentAssertions;
using Moq;
using Soat.CleanCoders.DipKata.Main;
using Xunit;
using static Soat.CleanCoders.DipKata.Main.FriendBuilder;

namespace Soat.CleanCoders.DipKata.Tests
{
    public class BirthdayGreeterShould
    {
        private readonly BirthdayGreeter        _birthdayGreeter;
        private readonly TextWriter             _consoleOutput;
        private readonly Mock<FriendRepository> _friendRepositoryMock;

        private string MailBuffer => _consoleOutput.ToString();

        public BirthdayGreeterShould()
        {
            _friendRepositoryMock = new Mock<FriendRepository>();
            _birthdayGreeter      = new BirthdayGreeter(_friendRepositoryMock.Object);
            _consoleOutput        = new StringWriter();
            Console.SetOut(_consoleOutput);
        }

        [Fact]
        public void Send_greeting_email_to_the_friend_born_today()
        {
            // Arrange
            var friend = AFriend().Build();

            _friendRepositoryMock
                .Setup(x => x.FindFriendsBornOn(It.IsAny<DateTime>()))
                .Returns(new[] { friend });

            // Act
            _birthdayGreeter.SendGreetings();

            // Assert
            var expectedMailContent =
                $"To:{friend.Email}, Subject: Happy birthday!, " +
                $"Message: Happy birthday, dear {friend.FirstName}!";

            MailBuffer.Should().Be(expectedMailContent);
        }

        [Fact]
        public void Send_no_greeting_email_when_its_nobody_birthday()
        {
            _friendRepositoryMock
                .Setup(x => x.FindFriendsBornOn(It.IsAny<DateTime>()))
                .Returns(Enumerable.Empty<Friend>());

            _birthdayGreeter.SendGreetings();

            MailBuffer.Should().BeNullOrEmpty();
        }
    }
}
