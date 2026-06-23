public class Main {
    public static void main(String[] args) {
        System.out.println("Demo 1: Email only");
        Notifier email = new EmailNotifier();
        email.send();
        System.out.println();

        System.out.println("Demo 2: SMS + Email");
        Notifier smsEmail = new SMSNotifierDecorator(new EmailNotifier());
        smsEmail.send();
        System.out.println();

        System.out.println("Demo 3: Slack + SMS + Email");
        Notifier slackSmsEmail = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        slackSmsEmail.send();
        System.out.println();

        System.out.println("Demo 4: SMS(outer) -> Slack(inner) -> Email");
        Notifier smsSlackEmail = new SMSNotifierDecorator(new SlackNotifierDecorator(new EmailNotifier()));
        smsSlackEmail.send();
    }
}