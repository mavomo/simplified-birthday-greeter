using System;
using System.Collections.Generic;

namespace Soat.CleanCoders.DipKata.Main
{
    public interface FriendRepository
    {
        IEnumerable<Friend> FindFriendsBornOn(DateTime today);
    }
}
