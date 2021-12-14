import time
#import the time library to calculate the execute time of program

def selectionSort(data,n):
#function for the sorting string using the selection sort
    
    #loop all string in array to be sorted
    for i in range (n):
        #unsorted string is sorted by consider the first element is the smallest
        min_str=data[i]
        min_index = i


        for x in range (i+1,n):
            #using i+1 because we want to skip to next element so that 
            # the smallest next can be swap with the first index
        
            if data[x]<min_str:
                min_str=data[x]
                min_index=x
                #smallest will be assign with min index and string to be swapped later on

        if min_index != i:
            #swap the found smallest with the first elemnent which i
            temp = data[i]
            data[i]=data[min_index]
            data[min_index]=temp

        #block will loop with the next unsorted element in array
        #which is now i=2 untill all element is been sorted
    return data


if __name__ == '__main__':

    start_time = time.time() #program execute time is started
    
    data=[] #an array been declared

    f = open("dataset.txt", "r") #open the text file

    for x in f:
        data.append(x.strip())
        #data in text file been added to array using append

    f.close()#close the text file

    size=len(data) #size of array

    selectionSort(data,size)#element in array send to function to be sorted

    for i in range (size):
        print(i+1,":",data[i])#print all element that has been sorted

    end_time=time.time()#program end time 

    print("\nTime taken for this algorithm in Python : %s Seconds" % (end_time - start_time))#print total executed time of program
    print("\n")


        