class DefangIP {
    public String defangIPaddr(String address) {
        StringBuilder test = new StringBuilder();
        for (int i=0; i < address.length(); i++){
            char c = address.charAt(i);
            if (c!='.'){
                test.append(c);
            }
            else{
                test.append("[.]");
            }
        }
        return test.toString();
    }

    public static void main(String[] args) {
        DefangIP test = new DefangIP();
        String testIP = "135.161.190.103";
        System.out.println(test.defangIPaddr(testIP));
    }
}