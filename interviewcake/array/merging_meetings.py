"""
Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.

To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as a tuple of integers
(start_time, end_time). These integers represent the number of 30-minute blocks past 9:00am.

For example:

  (2, 3)  # Meeting from 10:00 – 10:30 am
  (6, 9)  # Meeting from 12:00 – 1:30 pm

Write a function merge_ranges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.

For example, given:

  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]

your function would return:

  [(0, 1), (3, 8), (9, 12)]

Do not assume the meetings are in order. The meeting times are coming from multiple teams.

Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges.
Here we've simplified our times down to the number of 30-minute slots past 9:00 am. But we want the function to work
even for very large numbers, like Unix timestamps. In any case, the spirit of the challenge is to merge meetings where
start_time and end_time don't have an upper bound.
"""

def merge_ranges(meetings):
    """Runtime: O(n lg n) Space: O(n)"""
    sorted_meetings = sorted(meetings, key=lambda tup: tup[0])
    print("Meeting: %s - %s" % (meetings[0]))
    new_meetings = [meetings[0]]
    for start_time, end_time in sorted_meetings[1:]:
        print("Meeting: %s - %s" % (start_time, end_time))
        latest_meeting_start, latest_meeting_end = new_meetings[-1]
        if start_time <= latest_meeting_end:
            new_meetings[-1] = (latest_meeting_start, max(latest_meeting_end, end_time))
        else:
            new_meetings.append((start_time, end_time))
    return new_meetings


if __name__ == '__main__':
    print(merge_ranges([
        (0, 1),
        (3, 5),
        (4, 8),
        (10, 12),
        (9, 10)
    ]))
    print(merge_ranges([
        (1, 5),
        (2, 3)
    ]))
