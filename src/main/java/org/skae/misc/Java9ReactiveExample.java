package org.skae.misc;

import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Java9ReactiveExample {
    public static void main(String[] args) {



//
//        String[] stringArray = {"Hello", "World","How", "are","you"};
//        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
//
//        publisher.subscribe(new Flow.Subscriber<String>() {
//
//            private Flow.Subscription subscription;
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                System.out.println("Subscribed");
//                this.subscription = subscription;
//                subscription.request(4);
//            }
//
//            @Override
//            public void onNext(String item) {
//                System.out.println("Processing :"+item);
//                this.subscription.request(1);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                    throwable.printStackTrace();
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("Completed");
//            }
//        });
//        //publisher.submit("Hello");
//
//        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));
//
//        publisher.close();

        String[] stringArray = {"Hello", "World","How", "are","you"};
        //Generate  same code for SubmissionPublisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new Flow.Subscriber<String>() {
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("Subscribed .. in Thread: "+Thread.currentThread().getName());
                this.subscription = subscription;
                this.subscription.request(3);
            }

            @Override
            public void onNext(String item) {
                System.out.println("Processing :"+item + " in Thread: "+Thread.currentThread().getName());
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });


        //publisher.submit("Hello");
        System.out.println("Publishing ..in Thread: "+Thread.currentThread().getName());

        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));
        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));
        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));
        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));
        Arrays.asList(stringArray).stream().forEach(s -> publisher.submit(s));


        publisher.close();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
