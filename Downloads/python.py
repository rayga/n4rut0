#!usr/bin/env python2

import locale

from datetime import datetime
import calender

locale.setlocale(locale.LC_ALL, 'en_US.UTF-8')
calender.setfirstweekday(calender.MONDAY)

date_format = '%B %d, %Y'
i = 0

with open('date.txt', 'r') as date_file:
