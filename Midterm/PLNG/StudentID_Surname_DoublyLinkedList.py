
class SongNode:
    def __init__(self, title):
        self.title = title
        self.prev = None
        self.next = None


class Playlist:
    def __init__(self):
        self.head = self.tail = self.current = None

    def add_song(self, title):
        new_song = SongNode(title)

        if self.head is None:
            self.head = self.tail = self.current = new_song
        else:
            new_song.prev = self.tail
            self.tail.next = new_song
            self.tail = new_song

        print(title, "added to playlist.")

    def next_song(self):
        if self.current is None:
            print("Playlist is empty.")
        elif self.current.next is None:
            print("This is the last song.")
        else:
            self.current = self.current.next
            print("Now playing:", self.current.title)

    def previous_song(self):
        if self.current is None:
            print("Playlist is empty.")
        elif self.current.prev is None:
            print("This is the first song.")
        else:
            self.current = self.current.prev
            print("Now playing:", self.current.title)

    def show_current(self):
        if self.current is None:
            print("Playlist is empty.")
        else:
            print("Currently playing:", self.current.title)

    def display_forward(self):
        if self.head is None:
            print("Playlist is empty.")
            return

        song = self.head
        print("Playlist (Forward):")

        while song:
            print(song.title)
            song = song.next

    def display_backward(self):
        if self.tail is None:
            print("Playlist is empty.")
            return

        song = self.tail
        print("Playlist (Backward):")

        while song:
            print(song.title)
            song = song.prev

    def remove_song(self, title):
        song = self.head

        while song and song.title.lower() != title.lower():
            song = song.next

        if song is None:
            print("Song not found.")
            return

        if song.prev:
            song.prev.next = song.next
        else:
            self.head = song.next

        if song.next:
            song.next.prev = song.prev
        else:
            self.tail = song.prev

        if self.current == song:
            self.current = song.next if song.next else song.prev

        print(title, "removed from playlist.")


playlist = Playlist()

while True:
    print("\n--------- Music Playlist ---------")
    print("1. Add Song")
    print("2. Next Song")
    print("3. Previous Song")
    print("4. Show Current Song")
    print("5. Display Playlist Forward")
    print("6. Display Playlist Backward")
    print("7. Remove Song")
    print("0. Exit")

    choice = input("Enter your choice: ")

    if choice == "1":
        title = input("Enter song title: ").strip()

        if title:
            playlist.add_song(title)
        else:
            print("Song title cannot be empty.")

    elif choice == "2":
        playlist.next_song()

    elif choice == "3":
        playlist.previous_song()

    elif choice == "4":
        playlist.show_current()

    elif choice == "5":
        playlist.display_forward()

    elif choice == "6":
        playlist.display_backward()

    elif choice == "7":
        title = input("Enter song title to remove: ").strip()

        if title:
            playlist.remove_song(title)
        else:
            print("Song title cannot be empty.")

    elif choice == "0":
        print("Exiting playlist.")
        break

    else:
        print("Invalid choice. Please try again.")
