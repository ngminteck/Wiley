

export interface Subject{
    id:number;
    name:String;
    score:number;
}

export interface Student{
    id:number;
    name:string;
    subject: Array<Subject>;
}

export const StudentJson = [
    {
        id:1,
        name:'Ng Min Teck',
        subject:[
            {
                id:1,
                name:'C',
                score:85

            },
            {
                id:2,
                name:'C++',
                score:70
            },
            {
                id:3,
                name:'C#',
                score:70
            },
            {
                id:4,
                name:'Java',
                score:70
            },
            {
                id:5,
                name:'Python',
                score:70
            },
        ]
    },
    {
        id:1,
        name:'Clarence',
        subject:[
            {
                id:4,
                name:'Java',
                score:100
            },
            {
                id:6,
                name:'MySQL',
                score:85
            },
            {
                id:7,
                name:'JPA',
                score:85
            },
            {
                id:8,
                name:'ANgular',
                score:70
            }
        ]
    }
]