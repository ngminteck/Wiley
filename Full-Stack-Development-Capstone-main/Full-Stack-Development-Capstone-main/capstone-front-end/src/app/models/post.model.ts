import { formatDate } from "@angular/common";

export class Post {
    postId: number | undefined;
    title: string | undefined;
    header: string | undefined;
    body: string | undefined;
    postDate: any | undefined;
    expireDate: any | undefined;
    isApproved: boolean | undefined;
    userId: number | undefined;
    categoryId: number | undefined;

    constructor() 
    {
      this.header = "My Title";
      this.title = this.header;
      this.body = "My Content";
      this.postDate = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');
      let date = new Date();
      this.expireDate = formatDate(date.setDate(date.getDate() + 30), 'yyyy-MM-dd', 'en_US');
      this.categoryId = 1;
      this.userId = 1;
      this.isApproved = false;
    }
}