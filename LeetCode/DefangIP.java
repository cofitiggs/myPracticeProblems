class DefangIP {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        DefangIP test = new DefangIP();
        String testIP = "135.161.190.103";
        System.out.println(test.defangIPaddr(testIP));
    }
}