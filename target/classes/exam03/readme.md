# Requirement of Exam-03

## Background

Assuming there is a kind of message, the structure is as below.

```java
public class Message {
    private MessageType msgType;
    private LocalDate msgTime;
    private List<Something> details;
}

public enum MessageType {
    Snapshot,
    Delta
}

public class Something {
    private String id;
    private String content;
}
```

When the ```msgType``` is ```Snapshot```, it means the ```Message``` object contains all the records of the ```Something``` at the point in time when the message is sent.

When the ```msgType``` is ```Delta```, it means the ```Message``` object only contains the records have been changed (include added and updated).

Message producer usually use the ```Delta``` message to distribute the data to consumer to save the bandwidth. But the first message always is a ```Snapshot``` message,
and occasionally use a ```Snapshot``` message instead of a ```Delta``` message to send all the records of ```Something``` in case any ```Delta``` message was lost.

## Requirement

As a consumer, when received a series of messages, wants to save the data into a proper data structure, thus it can be used for a query to return all the records of ```Something``` at any given point in time.

For example, you received following messages.

```json
[
    {"msgType": "Snapshot", "msgTime": "2022-03-01 09:00:00", "details": [{"id": "1", "content": "a"}]},
    {"msgType": "Delta", "msgTime": "2022-03-01 12:00:00", "details": [{"id": "1", "content": "A" }, {"id": "2", "content": "B" }]},
    {"msgType": "Snapshot", "msgTime": "2022-03-01 15:30:00", "details": [{"id": "2", "content": "B" }]},
    {"msgType": "Delta", "msgTime": "2022-03-01 16:00:00", "details": [{"id": "3", "content": "C" }]},
    {"msgType": "Delta", "msgTime": "2022-03-01 20:00:00", "details": [{"id": "4", "content": "D" }]}
]
```

When user inputs ```2022-03-01 10:00:00```, the function returns:

```json
[
    {"id": "1", "content": "a"}
]
```

And when the input is ```2022-03-01 15:15:00```, the result is:

```json
[
    {"id": "1", "content": "A" },
    {"id": "2", "content": "B" }
]
```

And when the input is ```2022-03-01 16:15:00```, the result is:

```json
[
    {"id": "2", "content": "B" },
    {"id": "3", "content": "C" }
]
```

**Please finish the ```Util``` class.**
