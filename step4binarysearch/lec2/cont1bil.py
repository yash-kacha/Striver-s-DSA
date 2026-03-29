import time
from datetime import datetime

def main():
    start_time = time.time()
    print("Program started at:", datetime.fromtimestamp(start_time).strftime("%H:%M:%S"))

    # Your loop
    temp=0
    for i in range(1_000_000_000):
        a+=1
    print(temp)

    end_time = time.time()
    print("Program ended at:", datetime.fromtimestamp(end_time).strftime("%H:%M:%S"))

    total_time = end_time - start_time
    print(f"Total time taken: {total_time:.2f} seconds")
    print(f"Which is about: {total_time/60:.2f} minutes")

if __name__ == "__main__":
    main()
