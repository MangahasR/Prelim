#Prog 1
user = input("Enter your name: ")

utf8_bytes = user.encode("utf-8")
print("1. ",utf8_bytes)

str_data = utf8_bytes.decode("utf-8")
print("2. ",str_data)

hex_str = user.encode('utf-8').hex()
print("3. ",hex_str)

hex_string = hex_str
clean_hex = hex_string.replace("0x", "")
byte_data = bytes.fromhex(clean_hex)
print("4. ",byte_data) 

obj_str = bytearray(user , "utf-8")
print("5. ",obj_str)

obj_str2 = bytearray(user , "utf-8")
print("6. ",obj_str2)

org_data = user
ere_data = org_data[6:12]
print("7. ",ere_data)

mod_str = user[0].lower() + user[1:]
print("8. ",mod_str)