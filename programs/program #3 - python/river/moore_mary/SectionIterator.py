from moore_mary.Iterator import Iterator
from moore_mary.Section import Section


class SectionIterator(Iterator):
    def __init__(self, sections) -> None:
        self.sections = sections

    def __iter__(self):  #GRADING: ITER_RESTRICT
        self.index = -1
        return self

    def __next__(self):
        self.index += 1

        try:
            while not isinstance(self.sections[self.index], Section):  # skip anything that is not a section
                self.index += 1
        except IndexError:  # stop if the end of the list is reached
            raise StopIteration

        return self.sections[self.index]  # return the next actual section
