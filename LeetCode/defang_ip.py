def defangIPaddr(address: str) -> str:
    return address.replace(".", "[.]")

print(defangIPaddr("135.161.190.103"))