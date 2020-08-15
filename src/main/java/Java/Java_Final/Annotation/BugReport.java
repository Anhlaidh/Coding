package Java.Java_Final.Annotation;

public @interface BugReport {
    enum Status {UNCONFIRMED,CONFIRMED,FIXED, NOTABUG};

    boolean showStopper() default true;

    String assignedTo() default "[note]";

    Status status() default Status.UNCONFIRMED;

    String[] reportedBy();
}
